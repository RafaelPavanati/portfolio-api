package com.pavanati.portfolio.gateway.mapper;

import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.domain.model.Projeto;
import com.pavanati.portfolio.gateway.model.request.ProjetoRequest;
import com.pavanati.portfolio.gateway.model.response.ProjetoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProjetoMapper {

    Projeto toModel(ProjetoRequest request);

    ProjetoResponse toResponse(Projeto model);
}
