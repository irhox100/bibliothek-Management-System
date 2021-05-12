package de.bibliothek.phase4;

import de.bibliothek.phase4.service.NutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    NutzerService nutzerService;
//    @Autowired
//    private DataSource dataSource;

    public SecurityConfig(NutzerService nutzerService){
        this.nutzerService = nutzerService;
    }


    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> {
            try {
                a.antMatchers("/").permitAll();
//                        .antMatchers("/bib/**").hasAuthority("ROLE_BIBLIOTHEKAR")
//                        .antMatchers("/kunde/**").hasAuthority("ROLE_KUNDE")
//                        .anyRequest().authenticated()
//                        .and().formLogin();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//        .dataSource(dataSource).withDefaultSchema()
//                .withUser(User.withUsername("nutzer1@hhu.de").password("pass").roles("BIBLIOTHEKAR"))
//                .withUser(User.withUsername("nutzer4@hhu.de").password("pass").roles("KUNDE"));
//        .usersByUsernameQuery("SELECT n.EMail, n.Passwort FROM Nutzer n WHERE EMail = ?")
//        .authoritiesByUsernameQuery("SELECT EMail,'BIBLIOTHEKAR' FROM Bibliothekar WHERE EMail = ?" +
//                " UNION SELECT EMail, 'KUNDE' FROM Kunde WHERE EMail = ? UNION SELECT ?, 'NUTZER' FROM Nutzer");
//    }


//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsPasswordService();
//        return authProvider;
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
//            if (nutzerService.isNutzerBibliothekar(auth.getPrincipal().toString())) {
//                authorities.add(new SimpleGrantedAuthority("ROLE_BIBLIOTHEKAR"));
//            }
//            else if(nutzerService.isNutzerKunde(auth.getPrincipal().toString())) {
//                authorities.add(new SimpleGrantedAuthority("ROLE_KUNDE"));
//            }
//        return authorities;
//    }
//
//    private Set<GrantedAuthority> initRoleService() {
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        Map<Object, Object> attributes = new HashMap<>(); //keep existing attributes
//        attributes.put(auth.getPrincipal(), auth.getCredentials());
//
//        Set<GrantedAuthority> authorities = new HashSet<>();
//
//        // Prüfen auf Rollen
//
//        if (nutzerService.isNutzerKunde(attributes.get("login").toString())) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_KUNDE"));
//        }
//
//        if (nutzerService.isNutzerBibliothekar(attributes.get("login").toString())) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_BIBLIOTHEKAR"));
//        }
//
//        return authorities;
//    }


}
