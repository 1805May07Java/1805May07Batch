package com.rev.pojo;

import java.util.Objects;

import com.rev.util.Format;

public enum AccountType {
	CHECKING, SAVINGS, CREDIT;

	public static long value(AccountType type) {
		Objects.requireNonNull(type);

		switch (type) {
		case CHECKING:
			return 1;
		case CREDIT:
			return 3;
		case SAVINGS:
			return 2;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String toString() {
		return Format.name(this.name());
	}
}
