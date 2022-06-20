package com.tcc.petApp.contract;

import com.tcc.petApp.contract.api.ContractRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractMapper {

    public ContractRequest contracttoContractRequest(Contract contract) {
        return ContractRequest.builder()
                .petName(contract.getPetName())
                .when(contract.getWhen())
                .careServiceId(contract.getCareServiceId())
                .petOwnerId(contract.getPetOwnerId())
                .build();
    }

    public Contract contractRequestToContract(ContractRequest contractRequest) {
        return Contract.builder()
                .petName(contractRequest.getPetName())
                .when(contractRequest.getWhen())
                .careServiceId(contractRequest.getCareServiceId())
                .petOwnerId(contractRequest.getPetOwnerId())
                .build();
    }

    public Contract updateSetterContract(Contract contract, ContractRequest contractRequest) {
        contract.setWhen(contractRequest.getWhen());
        return contract;
    }

    public List<ContractRequest> contractListToContractRequestList(List<Contract> contractList) {
        List<ContractRequest> contractRequestList = new ArrayList<>();
        for (Contract contract : contractList) {
            contractRequestList.add(contracttoContractRequest(contract));
        }
        return contractRequestList;
    }
}
