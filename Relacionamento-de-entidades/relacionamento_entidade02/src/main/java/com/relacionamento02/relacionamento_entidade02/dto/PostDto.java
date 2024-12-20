package com.relacionamento02.relacionamento_entidade02.dto;


import lombok.Builder;

import java.util.List;

@Builder
public record PostDto(String titulo, String conteudo, List<Long> comentarios) {
}
