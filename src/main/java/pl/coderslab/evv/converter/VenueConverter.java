package pl.coderslab.evv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;
import pl.coderslab.evv.entity.Venue;
import pl.coderslab.evv.repositories.VenueRepository;
@Component
@ConfigurationPropertiesBinding //zarejestrowac konwerter
public class VenueConverter implements Converter<String, Venue> {
    @Autowired
    VenueRepository venueRepository;

    @Override
    public Venue convert(String s){ //trzeba zarejestrowac w app config
        return venueRepository.findById(Long.parseLong(s));
    }


}
