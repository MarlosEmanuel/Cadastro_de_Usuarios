package dev.marlosemanuel.Cadastro_de_Usuarios_backend.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dx6zdfy0f",
                "api_key","518558637915642",
                "api_secret","V6prOmTz9jWsBab_HxJbNApR2JM"
        ));
    }

}
