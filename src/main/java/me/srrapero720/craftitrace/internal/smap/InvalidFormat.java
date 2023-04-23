package me.srrapero720.craftitrace.internal.smap;

import java.io.IOException;

public class InvalidFormat extends IOException {
	private static final long serialVersionUID = -2212135394479100394L;

	InvalidFormat(String message) {
		super(message);
	}
}