package com.mobileapplication.domain;

import javax.persistence.*;

@Entity
@Table(name = "client_role")
public class ClientRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_email", referencedColumnName = "email", nullable = false)
//    @Formula(value="( select v_pipe_offerprice.offerprice_fk from v_pipe_offerprice where v_pipe_offerprice.id = id )")
//    @Formula(value="( select client.email from client where client.email = client_email )")
    private Client client;
    @Column(name = "role")
    private String role;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
