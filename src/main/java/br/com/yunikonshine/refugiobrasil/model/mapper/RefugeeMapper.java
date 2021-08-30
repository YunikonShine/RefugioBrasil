package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeResponse;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeSimpleResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class}, uses = {
        AddressMapper.class, DocumentMapper.class, FormationMapper.class,
        LanguageMapper.class, PhoneMapper.class, ProfessionMapper.class,
        NecessityMapper.class})
public interface RefugeeMapper {

    @BeanMapping(qualifiedByName = "setAdditionalData")
    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "birthCountry", target = "birthCountryId")
    @Mapping(target = "birthCountry", ignore = true)
    @Mapping(source = "originCountry", target = "originCountryId")
    @Mapping(target = "originCountry", ignore = true)
    Refugee fromRequest(RefugeeRequest refugeeRequest);

    @Mapping(target = "originCountry", source = "originCountry.name")
    @Mapping(target = "birthCountry", source = "birthCountry.name")
    RefugeeSimpleResponse toRefugeeSimpleResponse(Refugee refugee);

    RefugeeResponse toRefugeeResponse(Refugee refugee);

    @AfterMapping
    @Named("setAdditionalData")
    default void setAdditionalData(@MappingTarget Refugee refugee) {
        String id = refugee.getId();

        refugee.getDocuments().forEach(i -> i.setRefugeeId(id));
        refugee.getProfessions().forEach(i -> i.setRefugeeId(id));
        refugee.getLanguages().forEach(i -> i.setRefugeeId(id));
        refugee.getFormations().forEach(i -> i.setRefugeeId(id));
        refugee.getPhones().forEach(i -> i.setRefugeeId(id));

        refugee.setNecessityId(refugee.getNecessity().getId());
        refugee.setAddressId(refugee.getAddress().getId());

        refugee.setCreationDate(LocalDateTime.now());
    }

}
