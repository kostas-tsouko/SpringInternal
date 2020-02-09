package gr.hua.dit.springpraktikh.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	DataSource dataSource;
	

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT users.id as username,password,enabled from users where id=? ")
		.authoritiesByUsernameQuery("select authorities.id as username,authority from authorities where id=?");

    }


	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable().
        	antMatcher("/api/**")
              .authorizeRequests()
                  .anyRequest().authenticated()
                  .and()
              .httpBasic();
        }
    }
    

    @Configuration
    @Order(2)
    public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter{

        @Override
        public void configure(WebSecurity web) throws Exception {
                    web.ignoring().antMatchers("/resources/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
    		http.authorizeRequests()
    		.antMatchers("/admin/**").hasRole("ADMIN")
    		.antMatchers("/authorities/**").hasRole("ADMIN")
    		.antMatchers("/student/list").hasAnyRole("ADMIN", "OFFICE", "COMPANY")
    		.antMatchers("/student/**").hasAnyRole("ADMIN", "STUDENT","OFFICE")
    		.antMatchers("/office/**").hasAnyRole("ADMIN", "OFFICE")
    		.antMatchers("/company/updateCompanyList").hasAnyRole("ADMIN", "COMPANY", "OFFICE")
    		.antMatchers("/company/list").hasAnyRole("ADMIN", "COMPANY", "OFFICE")
    		.antMatchers("/company/updateCompany").hasRole("OFFICE")
    		.antMatchers("/company/deleteCompany/{id}").hasAnyRole("OFFICE", "ADMIN")
    		.antMatchers("/company/**").hasAnyRole("ADMIN", "COMPANY")
    		.antMatchers("/company/addCompany").hasRole("OFFICE")
    		.antMatchers("/stdapps/saveStdapps").hasAnyRole("COMPANY", "STUDENT")
    		
    		.antMatchers("/stdapps/listforcompanies").hasRole("COMPANY")
    		.antMatchers("/stdapps/listforstudents").hasRole("STUDENT")
    		.antMatchers("/stdapps/list").hasRole("COMPANY")
    		.antMatchers("/**").authenticated()
    		
    		.and().formLogin().loginPage("/login")
    		.loginProcessingUrl("/authUser").permitAll().and().logout().permitAll();
        }
        

    }
}
