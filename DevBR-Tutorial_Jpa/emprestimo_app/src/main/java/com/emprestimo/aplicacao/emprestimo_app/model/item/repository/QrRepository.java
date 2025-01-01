package com.emprestimo.aplicacao.emprestimo_app.model.item.repository;

import com.emprestimo.aplicacao.emprestimo_app.model.item.qr.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrRepository extends JpaRepository<QrCode, Integer> {
}
