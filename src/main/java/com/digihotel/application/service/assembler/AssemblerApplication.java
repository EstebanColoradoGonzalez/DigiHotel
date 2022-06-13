package com.digihotel.application.service.assembler;

public interface AssemblerApplication<D, T>
{
    D assembleDomainFromDTO(T dto);

    T assembleDTOFromDomain(D domain);
}