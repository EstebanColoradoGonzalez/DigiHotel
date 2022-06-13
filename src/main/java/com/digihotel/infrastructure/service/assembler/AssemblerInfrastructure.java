package com.digihotel.infrastructure.service.assembler;

public interface AssemblerInfrastructure<D, E>
{
    D assembleDomainFromEntity(E entity);

    E assembleEntityFromDomain(D domain);
}