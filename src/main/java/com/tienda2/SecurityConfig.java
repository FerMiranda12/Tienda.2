
package com.tienda2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); //agarra el password de BD y lo encripta
    }

    //@Bean
    //public UserDetailsService userDetailsService() {
        //InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //manager.createUser(User.withUsername("admin")
               // .password("{noop}123")
               // .roles("ADMIN", "VENDEDOR", "USER")
               // .build());
       // manager.createUser(User.withUsername("vendedor")
               // .password("{noop}123")
               // .roles("VENDEDOR", "USER")
               // .build());
      //  manager.createUser(User.withUsername("user")
                //.password("{noop}123")
                //.roles("USER")
                //.build());
       // return manager;
   // }
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/",
                        "/index",
                        "/errores/**",
                        "/error",
                        "/webjars/**").permitAll() //permite todas esas vistas a todos los usuarios
                .requestMatchers(
                        "/articulo/nuevo",
                        "/articulo/guardar",
                        "/articulo/modificar/**",
                        "/articulo/eliminar/**",
                        "/categoria/nuevo",
                        "/categoria/guardar",
                        "/categoria/modificar/**",
                        "/categoria/eliminar/**",
                        "/cliente/nuevo",
                        "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**")
                .hasRole("ADMIN") //permite todas esas vistas a solo admin
                .requestMatchers(
                        "/articulo/listado",
                        "/categoria/listado",
                        "/cliente/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")  //permite todas esas vistas a todos los user
                .requestMatchers(
                        "/carrito/agregar/'' ",
                        "/carrito/listado/'' ")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling() //esto es para que si alguien que no tiene permisos sobre la vista que apreto le salga error
                .accessDeniedPage("/errores/403");//lo mismo de arriba, lo del error, me redirigue a errores/403
        return http.build();
    }
}