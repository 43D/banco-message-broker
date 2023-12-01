package br.edu.utfpr.td.tsi.consumer.services.specification;

import br.edu.utfpr.td.tsi.dto.Transaction;

public class SuspiciousTransactionSpecification {
    public static boolean checkTransaction(Transaction dto) {
        if (dto.getAmount() >= 40000)
            return true;

        return false;
    }
}
