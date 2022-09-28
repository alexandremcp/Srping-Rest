package com.client.ws.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {

    private Long id;

    @NotBlank(message = "campo name não pode ser nulo ou vazio")
    @Size(min = 5, max = 30)
    private String name;

    @Max(value = 12, message = "campo accessMonth não pode ser maior que 12")
    private Long accessMonth;

    @NotNull(message = "campo price não pode ser nulo")
    private BigDecimal price;

    @NotBlank(message = "campo productType não pode ser nulo ou vazio")
    @Size(min = 5, max = 15, message = "campo productType deve ter entre 5 e 15 caracteres")
    private String productKey;

}

/*
SubscriptionTypeDto
===================
É responsável por representar os dados de um SubscriptionType e fazer a entrada de dados para o SubscriptionType.
A classe faz o mapeamento de um DTO para uma entidade e vice-versa.

Observação: Para que as validações tenham efeito deve ser inseriada a aanotação @Valid no respectivo controller.

Javax validation
================
É uma biblioteca que permite a validação de dados de entrada, como por exemplo, se um campo é nulo ou vazio,
    se um campo é maior que um valor, se um campo é menor que um valor, etc.
    Tipos de validação:
        @NotBlank --> Não permite que o campo seja nulo ou vazio
        @Size --> Tamanho mínimo e máximo
        @Max --> Valor máximo
        @NotNull --> Não permite nulo
        @Min --> Valor mínimo
        @Email --> Valida se o campo é um email
        @Pattern --> Valida se o campo é um padrão, exemplo: @Pattern(regexp = "[0-9]{2}\\\\.[0-9]{3}\\\\.[0-9]{3}\\\\/[0-9]{4}\\\\-[0-9]{2}")
        @NotEmpty --> Não permite que o campo seja nulo, vazio ou com espaços em branco
        @Positive --> Não permite que o campo seja negativo
        @PositiveOrZero --> Não permite que o campo seja negativo ou zero
        @Negative --> Não permite que o campo seja positivo
        @Past --> Não permite que o campo seja uma data futura
        @Future --> Não permite que o campo seja uma data passada
        @PastOrPresent --> Não permite que o campo seja uma data futura
        @FutureOrPresent --> Não permite que o campo seja uma data passada
        @DecimalMax --> Não permite que o campo seja maior que o valor informado
        @DecimalMin --> Não permite que o campo seja menor que o valor informado
        @Digits --> Não permite que o campo tenha mais casas decimais que o informado
        @Valid --> Valida os campos de um objeto
        @Validated --> Valida os campos de um objeto
        @AssertTrue --> Não permite que o campo seja falso
        @AssertFalse --> Não permite que o campo seja verdadeiro
        @CreditCardNumber --> Não permite que o campo não seja um número de cartão de crédito válido
        @Currency --> Não permite que o campo não seja uma moeda válida
        @EAN --> Não permite que o campo não seja um número de EAN válido
        @ISBN --> Não permite que o campo não seja um número de ISBN válido
        @Length --> Não permite que o campo tenha um tamanho diferente do informado
        @LuhnCheck --> Não permite que o campo não seja um número de Luhn válido
        @Range --> Não permite que o campo tenha um valor diferente do informado
        @SafeHtml --> Não permite que o campo tenha um valor diferente do informado
        @ScriptAssert --> Não permite que o campo tenha um valor diferente do informado
        @URL --> Não permite que o campo não seja uma URL válida
        @UUID --> Não permite que o campo não seja um UUID válido
        @ScriptAssert --> Não permite que o campo tenha um valor diferente do informado
 */
