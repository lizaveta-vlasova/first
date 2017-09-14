package com.mobileapplication.controller;

import com.mobileapplication.domain.*;
import com.mobileapplication.service.*;
import com.mobileapplication.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller

public class ClientController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OrderService orderService;

    /**
     * return page with a list of customer contracts
     *
     * @param model
     * @return page with a list of customer contracts
     */
    @RequestMapping(path = "/clientAccount/chooseContract", method = RequestMethod.GET)
    public String clientAccountChooseContract(Model model) {
        Client currentClient = loginService.getCurrentClient();
        List<Contract> contractsByClientId = contractService.findContractsByClient(currentClient);
        model.addAttribute("contractsList", contractsByClientId);
        model.addAttribute("client", currentClient);
        return "client/clientAccountChooseContracr";
    }

    /**
     * return page with information about client
     *
     * @param model
     * @param clientId
     * @return
     */
    @RequestMapping(path = "/clientAccount/userInfo/{clientId}")
    public String userInfo(Model model, @PathVariable("clientId") Integer clientId) {
        model.addAttribute("client", clientService.getClientById(clientId));
        return "client/partials/clientProfile";
    }

    /**
     * client choose the contract, method returns page with information about selected contract
     *
     * @param model
     * @param contractId
     * @return page with information about selected contract
     */
    @RequestMapping(path = "/clientAccount/{contractId}", method = RequestMethod.GET)
    public String clientAccount(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        boolean isContractBLocked = contractService.isContractBlocked(contractId);
        boolean isContractBlockedByUser = contractService.isContractBlockedByUser(contractId);
        boolean isContractBlockedByAdmin = contractService.isContractBlockedByAdmin(contractId);
        model.addAttribute("contractId", contractId);
        model.addAttribute("isContractBLocked", isContractBLocked);
        model.addAttribute("isContractBlockedByUser", isContractBlockedByUser);
        model.addAttribute("isContractBlockedByAdmin", isContractBlockedByAdmin);
        model.addAttribute("contract", currentContract);
        return "client/newClientAccount";
    }

    /**
     * return page with list of tariffs
     *
     * @param model
     * @param contractId
     * @return list of tariffs
     */
    @RequestMapping(path = "/clientAccount/tariff/{contractId}", method = RequestMethod.GET)
    public String clientAccountTariff(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        Integer currentTariffId = contract.getTariff().getId();
        model.addAttribute("currentTariffId", currentTariffId);
        model.addAttribute("tariffList", tariffService.tariffList());
        return "client/partials/tariff";
    }

    /**
     * client change tariff
     *
     * @param model
     * @param contractId
     * @param tariffId
     * @return redirect to the same page with update
     */
    @RequestMapping(path = "/clientAccount/tariff/{contractId}/newTariff/{tariffId}", method = RequestMethod.GET)
    public String changeContractTariff(
            Model model,
            @PathVariable("contractId") Integer contractId,
            @PathVariable("tariffId") Integer tariffId
    ) {
        Tariff tariff = tariffService.getTariffById(tariffId);
        Contract contract = contractService.findContractById(contractId);
        contract.setTariff(tariff);
        contractService.updateContract(contract);
        model.addAttribute("contractId", contractId);
        return "redirect:/clientAccount/tariff/" + contractId;
    }

    /**
     * return page with list of available options for current contract
     *
     * @param model
     * @param contractId
     * @return list of available options for current contract
     */
    @RequestMapping(path = "/clientAccount/options/{contractId}", method = RequestMethod.GET)
    public String clientAccountOptions(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        Tariff tariff = contract.getTariff();
        Set<Option> currentOptions = contract.getOptions();
        Set<Option> availableOptions = tariff.getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("contractId", contractId);
        model.addAttribute("tariffOptions", myTreeSet);
        model.addAttribute("currentOptions", currentOptions);
        return "client/partials/options";
    }

    /**
     * add option for current contract, update contract
     *
     * @param model
     * @param optionId
     * @param contractId
     * @return redirect to the same page with update
     */
    @RequestMapping(path = "/clientAccount/options/{contractId}/add/{optionId}", method = RequestMethod.GET)
    public String addOptionByContractId(Model model,
                                        @PathVariable("optionId") Integer optionId,
                                        @PathVariable("contractId") Integer contractId) {
        contractService.addOptionByContractId(optionId, contractId);
        return "redirect:/clientAccount/options/" + contractId;
    }

    /**
     * remove option for current contract, update contract
     *
     * @param model
     * @param optionId
     * @param contractId
     * @return redirect tp the same page with update
     */
    @RequestMapping(path = "/clientAccount/options/{contractId}/remove/{optionId}", method = RequestMethod.GET)
    public String removeOptionByContractId(Model model,
                                           @PathVariable("optionId") Integer optionId,
                                           @PathVariable("contractId") Integer contractId) {
        contractService.removeOptionByContractId(optionId, contractId);
        return "redirect:/clientAccount/options/" + contractId;
    }


    /**
     * return page where client can block or unblock his contract
     *
     * @param model
     * @param contractId
     * @return
     */
    @RequestMapping(path = "/clientAccount/block/{contractId}", method = RequestMethod.GET)
    public String pageToBlockNumber(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        model.addAttribute("currentContract", contract);
        return "client/partials/block";
    }

    /**
     * client block current contract
     *
     * @param model
     * @param contractId
     * @return redirect to main page with update (some function are disable)
     */
    @RequestMapping(path = "/clientAccount/block/{contractId}/blocked", method = RequestMethod.GET)
    public String getBlock(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        contractService.userBlocked(currentContract);
        return "redirect:/clientAccount/" + contractId;
    }

    /**
     * client unblock current contract
     *
     * @param model
     * @param contractId
     * @return redirect ro main page with update (all functions are available)
     */
    @RequestMapping(path = "/clientAccount/block/{contractId}/unblocked", method = RequestMethod.GET)
    public String getUnblock(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        contractService.userUnblocked(currentContract);
        return "redirect:/clientAccount/" + contractId;
    }

    @RequestMapping("clientAccount/bucket/{clientId}")
    public String clientAccountBucket(Model model, @PathVariable("clientId") Integer clientId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();
        List<Order> orderList = orderService.findOrdersBySessionId(sessionId);
        if (orderList.isEmpty()) {
            return "client/partials/emptyBucket";
        } else {
            model.addAttribute("order", orderList);
            model.addAttribute("client", clientService.getClientById(clientId));
            return "client/partials/bucket";
        }
    }

    @RequestMapping(path = "/clientAccount/addOrder/{clientId}")
    public String addOrderFromUserProfile(@PathVariable("clientId") Integer clientId) {
        Client currentClient = clientService.getClientById(clientId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();
        List<Order> orderList = orderService.findOrdersBySessionId(sessionId);
        for (Order order : orderList) {
            order.setStatus("в работе");
            order.setBucket(1);
            order.setClient(currentClient.getEmail());
            orderService.update(order);
        }
        /*order.setClient(currentClient.getEmail());
        orderService.update(order);*/
        return "redirect:/clientAccount/chooseContract";
    }

    @RequestMapping(path = "/clientAccount/orders/{clientId}")
    public String orders(Model model, @PathVariable("clientId") Integer clientId) {
        List<Order> orderList = orderService.getOrdersByEmail(clientService.getClientById(clientId).getEmail());
        model.addAttribute("orderList", orderList);
        return "client/partials/orders";
    }
}

