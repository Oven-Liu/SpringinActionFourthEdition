package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import spittr.data.SpitterRepository;
import spittr.service.SpitterUserService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
        .loginPage("/login")
      .and()
        .logout()
          .logoutSuccessUrl("/")
          .logoutUrl("/signout")
      .and()
      .rememberMe()
        .tokenRepository(new InMemoryTokenRepositoryImpl())
        .tokenValiditySeconds(2419200)
        .key("spittrKey")
      .and()
       .httpBasic()
         .realmName("Spittr")
      .and()
      .authorizeRequests()
        // .antMatchers("/").authenticated()
        // .antMatchers("/spitter/me").authenticated()
        // .antMatchers("/spitter/me").access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.2')")
        // .antMatchers(HttpMethod.POST, "/spittles").authenticated()
        // .anyRequest().permitAll()
          .antMatchers("/spitter/me").hasRole("SPITTER")
          .antMatchers(HttpMethod.POST, "/spittles").hasRole("SIPTTER")
          .anyRequest().permitAll()
      .and()
      .requiresChannel()
          .antMatchers("/spitter/form").requiresSecure();
  }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http
  //     .authorizeRequests()
  //       .antMatchers("/spitter/me").hasRole("SPITTER")
  //       .antMatchers("/spitter/me").access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.2')")
  //       .antMatchers(HttpMethod.POST, "/spittles").hasRole("SIPTTER")
  //       .anyRequest().permitAll();
  // }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http
  //     .authorizeRequests()
  //       .antMatchers("/spitter/me").hasRole("SPITTER")
  //       .antMatchers(HttpMethod.POST, "/spittles").hasRole("SIPTTER")
  //       .anyRequest().permitAll()
  //     .and()
  //         .requiresChannel()
  //         .antMatchers("/spitter/form").requiresSecure()
  //         .antMatchers("/").requiresInsecure()
  //     .and()
  //       .csrf().disable();
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth
  //     .inMemoryAuthentication()
  //       .withUser("user").password("password").authorities("ROLE_USER").and()
  //       .withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN");
  // }

  // @Autowired
  // DataSource dataSource;
  //
  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth
  //     .jdbcAuthentication()
  //           .dataSource(dataSource)
  //           .usersByUsernameQuery("select username, true from Spitter where username=?")
  //           .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
  //           .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth
  //     .ldapAuthentication()
  //           .userSearchBase("ou=people")
  //           .userSearchFilter("(uid={0})")
  //           .groupSearchBase("ou=groups")
  //           .groupSearchFilter("member={0}")
  //           .passwordCompare()
  //           .passwordEncoder(new Md5PasswordEncoder())
  //           .passwordAttribute("passcode");
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth
  //     .ldapAuthentication()
  //           .userSearchBase("ou=people")
  //           .userSearchFilter("(uid={0})")
  //           .groupSearchBase("ou=groups")
  //           .groupSearchFilter("member={0}")
  //           .contextSource()
  //           .url("ldap://habuma.com:389/dc=habuma,dc=com");
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth
  //     .ldapAuthentication()
  //           .userSearchBase("ou=people")
  //           .userSearchFilter("(uid={0})")
  //           .groupSearchBase("ou=groups")
  //           .groupSearchFilter("member={0}")
  //           .contextSource()
  //           .root("dc=habuma")
  //           .ldif("classpath:users.ldif");
  // }

  @Autowired
  private SpitterRepository spitterRepository;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(new SpitterUserService(spitterRepository));
  }

  
}
