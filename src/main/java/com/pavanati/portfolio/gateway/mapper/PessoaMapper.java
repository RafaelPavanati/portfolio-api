package com.pavanati.portfolio.gateway.mapper;

import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.gateway.model.request.PessoaRequest;
import com.pavanati.portfolio.gateway.model.response.PessoaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PessoaMapper {

    Pessoa toModel(PessoaRequest request);

    PessoaResponse toResponse(Pessoa model);
}
