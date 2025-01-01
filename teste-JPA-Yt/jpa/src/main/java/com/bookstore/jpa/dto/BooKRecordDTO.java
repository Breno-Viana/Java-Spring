package com.bookstore.jpa.dto;

import java.util.Set;
import java.util.UUID;

public record BooKRecordDTO(String title,
                            UUID publisherId,
                            Set<UUID> authorId,
                            String reviewComment) {
}
