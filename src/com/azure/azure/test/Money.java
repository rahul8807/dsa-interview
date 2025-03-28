package com.azure.azure.test;

import java.math.BigDecimal;

public record Money(int transactionId, BigDecimal amount) {
}
