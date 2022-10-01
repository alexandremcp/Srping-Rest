package com.client.ws.ws.rasmooplus.dto;

import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.ws.rasmooplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "O valor não pode ser nulo ou vazio")
    @Size(min = 6, message = "O valor deve ter no mínimo 6 caracteres")
    private String name;

    @Email(message = "inválido")
    private String email;

    @Size(min = 11, message = "O valor deve ter no mínimo 11 caracteres")
    private String phone;

    @CPF(message = "inválido")
    private String cpf;

    LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();

    @NotNull(message = "O valor não pode ser nulo ou vazio")
    private Long userTypeId;

    private Long subscriptionTypeId;
}
