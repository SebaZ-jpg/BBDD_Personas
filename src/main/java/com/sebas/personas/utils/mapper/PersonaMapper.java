package com.sebas.personas.utils.mapper;

import com.sebas.personas.database.entity.Persona;
import com.sebas.personas.web.dto.CrearPersonaRequest;
import com.sebas.personas.web.dto.PersonaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PersonaMapper {

    Persona toEntity(CrearPersonaRequest request);

    PersonaResponse toResponse(Persona persona);
}