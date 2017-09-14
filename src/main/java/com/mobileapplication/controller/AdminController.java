package com.mobileapplication.controller;

import com.mobileapplication.domain.*;
import com.mobileapplication.dto.ClientDTO;
import com.mobileapplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller

public class AdminController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private OrderService orderService;

    PasswordEncoder passwordEncoder;

    @RequestMapping(path = "/adminAccount")
    public String adminAccount() {
        return "admin/newAdminAccount";
        //return "admin/adminAccount";
    }

    /**
     * search full list of clients
     *
     * @param model
     * @return list of client
     */
    @RequestMapping(path = "/adminAccount/clientList")
    public String clientList(Model model) {
        model.addAttribute("clientList", clientService.clientList());
        return "admin/partials/clientList";
    }

    /**
     * Get page with list of tarrifs
     *
     * @param model
     * @return list od tarrifs
     */
    @RequestMapping(path = "/adminAccount/addTariff")
    public String pageToAddTariff(Model model) {
        model.addAttribute("tariffList", tariffService.tariffList());
        return "admin/partials/addTariff";
    }

    /**
     * Get page to create new tariff
     *
     * @return page with input forn for create new tariff
     */
    @RequestMapping(path = "/adminAccount/createNewTariff")
    public String createNewTariff() {
        return "admin/partials/createNewTariff";
    }

    /**
     * search tariff by id, get page to change tariff
     *
     * @param tariffId
     * @param model
     * @return page with input form for change
     */
    @RequestMapping("/adminAccount/changeDataTariff/{tariffId}")
    public String changeDataTariff(@PathVariable("tariffId") Integer tariffId,
                                   Model model) {
        model.addAttribute("tariff", tariffService.getTariffById(tariffId));
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/changeDataTariff";
    }

    /**
     * search tariff by id, add and remove options for selected tariff
     *
     * @param tariffId
     * @param model
     * @return page with list of options for add and remove for selected tariff
     */
    @RequestMapping("/adminAccount/addAndRemoveOptionsForTariff/{tariffId}")
    public String addAndRemoveOptionsForTariff(@PathVariable("tariffId") Integer tariffId,
                                               Model model) {
        Tariff currentTariff = tariffService.getTariffById(tariffId);

        model.addAttribute("tariff", currentTariff);
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/addAndRemoveOptionsForTariff";
    }

    /**
     * Get page with Information about selected tariff
     *
     * @param model
     * @param tariffId
     * @return jsp page with information about tariff
     */
    @RequestMapping(path = "/adminAccount/editTariff/{tariffId}")
    public String editTariff(Model model, @PathVariable("tariffId") Integer tariffId) {
        model.addAttribute("tariff", tariffService.getTariffById(tariffId));
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/editTariff";
    }

    /**
     * Selected tariff updates, and then save new information
     *
     * @param tariff
     * @param tariffId
     * @param model
     * @return page with information about selected tariff
     */
    @RequestMapping("/adminAccount/editTariff/updateTariff/{tariffId}")
    public String saveEditTariff(@ModelAttribute("tariff") Tariff tariff,
                                 @PathVariable("tariffId") Integer tariffId,
                                 Model model) {
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        currentTariff.setName(tariff.getName());
        currentTariff.setPrice(tariff.getPrice());
        tariffService.changeTariff(currentTariff);
        model.addAttribute("tariffId", currentTariff.getId());
        return "redirect:/adminAccount/editTariff/" + tariffId;
    }

    /**
     * add option for selected tariff, if admin will try to add incompatible option, he will see alert
     * with error message, if add option will succesfull, will redirect to the same page with new data
     *
     * @param tariffId
     * @param optionId
     * @param model
     * @return redirect to the same page
     */
    @RequestMapping("/adminAccount/editTariff/{tariffId}/add/{optionId}")
    public String editTariffAddOption(@PathVariable("tariffId") Integer tariffId,
                                      @PathVariable("optionId") Integer optionId,
                                      Model model) {
        Set<Option> option = optionService.findOptionById(optionId).getIncompatibleOptions();
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        Set<Option> availableOptions = currentTariff.getAvailableOptions();
        if (tariffService.isOptionsCompatible(option, availableOptions)) {
            return "Вы пытаетесь добавить несовместимые опции";
        } else {
            tariffService.addOptionByTariffId(tariffId, optionId);
            model.addAttribute("tariffId", tariffId);
            return "redirect:/adminAccount/addAndRemoveOptionsForTariff/" + tariffId;
        }

    }

    /**
     * remove option for selected tariff, then redirect to the same page with new data
     *
     * @param tariffId
     * @param optionId
     * @param model
     * @return redirect to the same page
     */
    @RequestMapping("/adminAccount/editTariff/{tariffId}/remove/{optionId}")
    public String editTariffRemoveOption(@PathVariable("tariffId") Integer tariffId,
                                         @PathVariable("optionId") Integer optionId,
                                         Model model) {
        tariffService.removeOptionByTariffId(tariffId, optionId);
        model.addAttribute("tariffId", tariffId);
        return "redirect:/adminAccount/addAndRemoveOptionsForTariff/" + tariffId;
    }

    /**
     * Create new tariff, redirect to page with list of options for add options for new tariff
     *
     * @param model
     * @param tariff
     * @return page with list of options
     */
    @RequestMapping(path = "/adminAccount/addTariff/add", method = RequestMethod.POST)
    public String addNewTariff(Model model, @ModelAttribute("tariff") Tariff tariff) {
        Tariff newTariff = tariffService.addNewTariff(tariff);
        model.addAttribute("tariffId", newTariff.getId());
        return "redirect:/adminAccount/addOptionsForTariff/" + newTariff.getId();
    }

    /**
     * remove selected tariff
     *
     * @param model
     * @param tariffId
     * @return page with list of tariffs
     */
    @RequestMapping(path = "/adminAccount/addTariff/{tariffId}/remove")
    public String removeTariff(Model model, @PathVariable("tariffId") Integer tariffId) {
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        tariffService.removeTariff(currentTariff);
        return "redirect:/adminAccount/addTariff";
    }

    /**
     * page with list of options to add for new tariff
     *
     * @param tariffId
     * @param model
     * @return list of options
     */
    @RequestMapping(path = "/adminAccount/addOptionsForTariff/{tariffId}")
    public String addOptionsForNewTariff(@PathVariable("tariffId") Integer tariffId, Model model) {
        List<Option> optionList = optionService.optionList();
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        model.addAttribute("currentTariff", currentTariff);
        model.addAttribute("options", optionList);
        model.addAttribute("tariffId", tariffId);
        return "admin/partials/addOptionsForTariff";
    }

    /**
     * save tariff with new options, if admin will adding incompatible options:
     * return alert with error message
     *
     * @param tariffId
     * @param optionId
     * @return redirect to the same page with new information
     */
    @RequestMapping(path = "/adminAccount/addOptionsForTariff/{tariffId}/add/{optionId}",
            method = RequestMethod.POST)
    public String saveOptionsForNewTariff(@PathVariable("tariffId") Integer tariffId,
                                          @PathVariable("optionId") Integer optionId) {
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        Option currentOption = optionService.findOptionById(optionId);
        if (tariffService.isOptionsCompatible(currentOption.getIncompatibleOptions(), currentTariff.getAvailableOptions())) {
            return "Вы пытаетесь добавить несовместимые опции";
        } else

        {
            tariffService.addOptionByTariffId(tariffId, optionId);
            return "redirect:/adminAccount/addOptionsForTariff/" + tariffId;
        }

    }

    /**
     * remove options for new tariff
     *
     * @param tariffId
     * @param optionId
     * @return redirect to the same page with new information
     */
    @RequestMapping(path = "/adminAccount/addOptionsForTariff/{tariffId}/remove/{optionId}",
            method = RequestMethod.POST)
    public String removeOptionsForNewTariff(@PathVariable("tariffId") Integer tariffId,
                                            @PathVariable("optionId") Integer optionId) {
        tariffService.removeOptionByTariffId(tariffId, optionId);
        return "redirect:/adminAccount/addOptionsForTariff/" + tariffId;
    }

    /**
     * search full list of options
     *
     * @param model
     * @return list of options
     */
    @RequestMapping(path = "/adminAccount/optionList")
    public String getPageToEditOptions(Model model) {
        List<Option> optionList = optionService.optionList();
        model.addAttribute("optionsList", optionList);
        return "admin/partials/optionList";
    }

    /**
     * get page to create new option
     *
     * @return page with input form
     */
    @RequestMapping(path = "/adminAccount/addOption")
    public String getPageToAddOption() {
        return "admin/partials/addOption";
    }

    @RequestMapping(path = "/adminAccount/optionList/{optionId}/remove", method = RequestMethod.GET)
    public String removeOption(@PathVariable("optionId") Integer optionId) {
        Option currentOption = optionService.findOptionById(optionId);
        optionService.removeOption(currentOption);
        return "redirect:/adminAccount/optionList";
    }

    /**
     * save new option
     *
     * @param option
     * @return redirect to page with full list of options
     */
    @RequestMapping(path = "/adminAccount/optionList/add", method = RequestMethod.POST)
    public String addOption(@ModelAttribute("option") Option option) {
        optionService.saveOption(option);
        return "redirect:/adminAccount/optionList";
    }

    /**
     * page to configure the compatibility of options with list of options
     *
     * @param model
     * @return page with list of options
     */
    @RequestMapping(path = "/adminAccount/compatibilityManagement")
    public String compatibilityManagement(Model model) {
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/compatibilityManagement";
    }

    /**
     * choose option to configure the compatibility with another options
     *
     * @param optionId
     * @param model
     * @return page with list of options, which stores information about the selected option
     */
    @RequestMapping(path = "/adminAccount/compatibilityManagement/{optionId}")
    public String compatibilityManagementChooseOption(@PathVariable("optionId")
                                                              Integer optionId, Model model) {
        model.addAttribute("optionList", optionService.optionList());
        model.addAttribute("currentOption", optionService.findOptionById(optionId));
        return "admin/partials/compatibilityManagementOption";
    }

    /**
     * make the option compatible with the selected one
     *
     * @param editOptionId
     * @param optionId
     * @param model
     * @return redirect to the same page with new information about compatibility
     */
    @RequestMapping(path = "/adminAccount/getCompatible/{optionId}/{currentOptionId}")
    public String getCompatible(@PathVariable("optionId") Integer editOptionId, @PathVariable("currentOptionId")
            Integer optionId, Model model) {
        Option currentOption = optionService.findOptionById(optionId);
        optionService.removeUncompotibleOption(editOptionId, optionId);
        model.addAttribute("currentOption", optionService.findOptionById(optionId));
        return "redirect:/adminAccount/compatibilityManagement/" + optionId;
    }

    /**
     * make the option incompatible with the selected one
     *
     * @param editOptionId
     * @param optionId
     * @param model
     * @return redirect to the same page with new information about compatibility
     */
    @RequestMapping(path = "/adminAccount/getUncompatible/{optionId}/{currentOptionId}")
    public String getUncompatible(@PathVariable("optionId") Integer editOptionId, @PathVariable("currentOptionId")
            Integer optionId, Model model) {
        Option currentOption = optionService.findOptionById(optionId);
        optionService.addUncompatibleOption(editOptionId, optionId);
        model.addAttribute("currentOption", optionService.findOptionById(optionId));
        return "redirect:/adminAccount/compatibilityManagement/" + optionId;
    }


    /**
     * get page to find contract by number
     *
     * @return page with input form for search
     */
    @RequestMapping(path = "/adminAccount/findContractPage")
    public String getToFindContractPage() {

        return "admin/partials/findContractPage";
    }

    /**
     * search contract by phone number, if contract with such number does not exist, admin will receive
     * alert with error message
     *
     * @param model
     * @param number
     * @return page with information about current contract
     * @throws IOException
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{number}")
    public String findContract(Model model, String number) throws IOException {
        try {
            Contract currentContract = contractService.findContractByNumber(number);
            model.addAttribute("currectContract", currentContract);
            model.addAttribute("tariffList", tariffService.tariffList());
            Set<Option> currentOptions = currentContract.getOptions();
            Set<Option> availableOptions = currentContract.getTariff().getAvailableOptions();
            TreeSet myTreeSet = new TreeSet();
            myTreeSet.addAll(availableOptions);
            model.addAttribute("tariffOptions", myTreeSet);
            return "admin/partials/getFoundContract";
        } catch (Exception e) {
            return "admin/partials/errors/failedNumberToFindContractPage";
        }
    }

    /**
     * admin search contract in list of clients, when he finds the right client,
     * he chooses the number, the contract he needs
     *
     * @param model
     * @param number
     * @return page with information about selected contract
     */
    @RequestMapping(path = "/adminAccount/findContractByClientList/{number}")
    public String findContractByClientList(Model model, @PathVariable("number") String number) {
        Contract currentContract = contractService.findContractByNumber(number);
        model.addAttribute("currectContract", currentContract);
        model.addAttribute("tariffList", tariffService.tariffList());
        Set<Option> currentOptions = currentContract.getOptions();
        Set<Option> availableOptions = currentContract.getTariff().getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("tariffOptions", myTreeSet);
        return "admin/partials/getFoundContract";

    }

    /**
     * get page with information about selected contract from contract settings
     *
     * @param contractId
     * @param model
     * @return contract information page
     */
    @RequestMapping(path = "/adminAccount/contractInfo/{contractId}")
    public String getFoundContractSecondPart(@PathVariable("contractId") Integer contractId,
                                             Model model) {
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        return "admin/partials/secondPartOfFoundContractPage";
    }

    /**
     * page where admin can block and unblock selected contract
     *
     * @param contractId
     * @param model
     * @return page where admin can block and unblock selected contract
     */
    @RequestMapping(path = "/adminAccount/blockAndUnblockContract/{contractId}")
    public String blockAndUnblockClientContract(@PathVariable("contractId") Integer contractId,
                                                Model model) {
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        return "admin/partials/blockAndUnblock";
    }

    /**
     * return page where admin can delete selected contract
     *
     * @param contractId
     * @param model
     * @return page where admin can delete selected contract
     */
    @RequestMapping(path = "/adminAccount/pageToRemoveContract/{contractId}")
    public String pageToRemoveContract(@PathVariable("contractId") Integer contractId,
                                       Model model) {

        model.addAttribute("contractId", contractId);
        return "admin/partials/pageToRemoveContract";
    }

    /**
     * remove contract
     *
     * @param contractId
     * @param model
     * @return redirect to page with input form for search contract by number
     */
    @RequestMapping(path = "/adminAccount/removeContract/{contractId}")
    public String removeContract(@PathVariable("contractId") Integer contractId,
                                 Model model) {

        contractService.removeContract(contractId);
        return "redirect:/adminAccount/findContractPage";
    }

    /**
     * return page with list of tariffs for change current tariff of this contract for another
     *
     * @param contractId
     * @param model
     * @return
     */
    @RequestMapping(path = "/adminAccount/changeTariffInContract/{contractId}")
    public String getPageToChangeTariff(@PathVariable("contractId") Integer contractId,
                                        Model model) {
        Contract currentContract = contractService.findContractById(contractId);
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("number", currentContract.getNumber());
        return "admin/partials/pageToChangeTariffForContract";
    }

    /**
     * return page with list of available options for selected contract
     *
     * @param contractId
     * @param model
     * @return page with list of available options for selected contract
     */
    @RequestMapping(path = "/adminAccount/editOptionsForContract/{contractId}")
    public String editOptionsForContract(@PathVariable("contractId") Integer contractId,
                                         Model model) {
        Contract currentContract = contractService.findContractById(contractId);
        Set<Option> availableOptions = currentContract.getTariff().getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("tariffOptions", myTreeSet);
        model.addAttribute("number", contractService.findContractById(contractId).getNumber());
        return "admin/partials/editOptionsForContract";
    }


    /**
     * change tariff for selected contract and save update contract
     *
     * @param model
     * @param contractId
     * @param tariffId
     * @return redirect to page with list of tariffs
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/change/{tariffId}")
    public String changeTariffInClientContract(Model model,
                                               @PathVariable("contractId") Integer contractId,
                                               @PathVariable("tariffId") Integer tariffId) {
        Contract currentContract = contractService.findContractById(contractId);
        Tariff tariff = tariffService.getTariffById(tariffId);
        currentContract.setTariff(tariff);
        contractService.updateContract(currentContract);
        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/changeTariffInContract/" + contractId;
    }

    /**
     * add option for selected contract and update contract
     *
     * @param optionId
     * @param contractId
     * @param model
     * @return redirect to page with list of options
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/add/{contractId}")
    public String addOptionsForClientContract(@PathVariable("optionId") Integer optionId,
                                              @PathVariable("contractId") Integer contractId,
                                              Model model) {
        contractService.addOptionByContractId(optionId, contractId);
        Contract contract = contractService.findContractById(contractId);

        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/editOptionsForContract/" + contractId;
    }

    /**
     * remove option in selected contract, update contract
     *
     * @param optionId
     * @param contractId
     * @param model
     * @return redirect to page with list of options
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/remove/{contractId}")
    public String removeOptionsForClientContract(@PathVariable("optionId") Integer optionId,
                                                 @PathVariable("contractId") Integer contractId,
                                                 Model model) {
        contractService.removeOptionByContractId(optionId, contractId);
        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/editOptionsForContract/" + contractId;
    }


    /**
     * Block contract by admin.
     *
     * @param model      model
     * @param contractId id contract
     * @return redirect to the same page with update
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/block")
    public String blockContract(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        model.addAttribute("contractId", contractId);
        contractService.userBlockedByAdmin(contract);
        return "redirect:/adminAccount/blockAndUnblockContract/" + contractId;
    }

    /**
     * unblock contract by admin
     *
     * @param model
     * @param contractId
     * @return redirect to the same page with update
     */
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/unblock")
    public String unblockContract(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        model.addAttribute("contractId", contractId);
        contractService.userUnblockedByAdmin(contract);
        return "redirect:/adminAccount/blockAndUnblockContract/" + contractId;
    }

    /**
     * page to create new client
     *
     * @return page to create new client with input form
     */
    @RequestMapping(path = "/adminAccount/addNewClient")
    public String addNewClientPage() {
        return "admin/partials/addNewClient";
    }

    /**
     * save new client
     *
     * @param client
     * @param model
     * @return
     */
    @RequestMapping(path = "/adminAccount/addNewClient/save", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client,
                            Model model) {
        Client newClient = clientService.saveClient(client);
        String salt = BCrypt.gensalt();
        String hashed_password = BCrypt.hashpw(newClient.getPassword(), salt);
        newClient.setPassword(hashed_password);
        clientService.updateClientInformation(newClient);

        model.addAttribute("clientId", newClient.getId());
        return "admin/partials/chooseTheRoleForNewClient";
        //return "redirect:/adminAccount/clientList";
    }

    /**
     * add to client new role
     *
     * @param clientId
     * @return page with list of clients
     */
    @RequestMapping(path = "/adminAccount/setAdminRole/{clientId}", method = RequestMethod.GET)
    public String setAdminRole(@PathVariable("clientId") Integer clientId) {
        Client client = clientService.getClientById(clientId);
        ClientRole clientRole = new ClientRole();
        clientRole.setRole("ROLE_ADMIN");
        clientRole.setClient(client);
        clientService.saveRole(clientRole);
        Set<ClientRole> roles = new HashSet<>();
        roles.add(clientRole);
        client.setClientRoles(roles);
        clientService.updateClientInformation(client);
        return "redirect:/adminAccount/clientList";
    }

    @RequestMapping(path = "/adminAccount/setClientRole/{clientId}", method = RequestMethod.GET)
    public String setClientRole(@PathVariable("clientId") Integer clientId) {
        Client client = clientService.getClientById(clientId);
        ClientRole clientRole = new ClientRole();
        clientRole.setRole("ROLE_USER");
        clientRole.setClient(client);
        clientService.saveRole(clientRole);
        Set<ClientRole> roles = new HashSet<>();
        roles.add(clientRole);
        client.setClientRoles(roles);
        client.getClientRoles();

        return "redirect:/adminAccount/clientList";
    }

    /**
     * return page for create new contract
     *
     * @param model
     * @return page for create new contract
     */
    @RequestMapping(path = "/adminAccount/addNewContract")
    public String addNewContractPage(Model model) {
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("clientList", clientService.clientList());
        model.addAttribute("numbers", phoneNumberService.numberList());
        return "admin/partials/addNewContract";
    }

    /**
     * save new contract
     *
     * @param tariffId
     * @param clientId
     * @param number
     * @return redirect to page with list of clients
     */
    @RequestMapping(path = "adminAccount/addNewContract/add", method = RequestMethod.POST)
    public String saveNewContract(
            @ModelAttribute("tariffId") Integer tariffId,
            @ModelAttribute("clientId") Integer clientId,
            @ModelAttribute("number") String number) {
        Contract contract = new Contract();
        contract.setTariff(tariffService.getTariffById(tariffId));
        contract.setClient(clientService.getClientById(clientId));
        contract.setNumber(number);
        contractService.saveContract(contract);
        return "redirect:/adminAccount/clientList";

    }

    @RequestMapping(path = "/adminAccount/clientRefactoring/{clientId}")
    public String clientRefactorInformation(@PathVariable("clientId") Integer clientId,
                                            Model model) {
        model.addAttribute("client", clientService.getClientById(clientId));
        return "admin/partials/clientRefactoring";
    }

    @RequestMapping(value = "/adminAccount/updateClientInformation/{clientId}")
    public String updateClientInformation(@ModelAttribute("client") Client client,
                                          @PathVariable ("clientId") Integer clientId) {
        String salt = BCrypt.gensalt();
        String hashed_password = BCrypt.hashpw(client.getPassword(), salt);
        client.setPassword(hashed_password);
        client.setId(clientId);
        clientService.updateClientInformation(client);
        return "redirect:/adminAccount/clientList";
    }
    @RequestMapping(path = "/adminAccount/deleteClient/{clientId}")
    public String deleteClient(@PathVariable ("clientId") Integer clientId){
        Client client = clientService.getClientById(clientId);
        clientService.deleteClient(client);
        return "redirect:/adminAccount/clientList";
    }
    @RequestMapping(path = "/adminAccount/orderList")
    public String orderList(Model model) {
        model.addAttribute("orderList", orderService.orderList());
        return "admin/partials/orderList";
    }
    @RequestMapping(path = "/adminAccount/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable ("orderId") Integer orderId){
        Order order = orderService.getOrderById(orderId);
        orderService.deleteOrder(order);
        return "redirect:/adminAccount/orderList";
    }
    @RequestMapping(path = "/adminAccount/changeOrderStatus/{orderId}")
    public String changeOrderStatus(@PathVariable ("orderId") Integer orderId){
        Order order = orderService.getOrderById(orderId);
        order.setStatus("выполнен");
        orderService.update(order);
        return "redirect:/adminAccount/orderList";
    }
}
