package com.relacionamento02.relacionamento_entidade02.dto;

import lombok.Builder;

@Builder
public record CommentaryDto(String autor, String comentario) {
}
