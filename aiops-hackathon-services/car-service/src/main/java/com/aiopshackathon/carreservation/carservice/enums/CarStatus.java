package com.aiopshackathon.carreservation.carservice.enums;

/**
 * The Enum Priority.
 */
public enum CarStatus {

	/** The Available. */
	AVAILABLE(0, "Available", "Available"),

	/** The Reserved. */
	RESERVED(1, "Reserved", "Reserved"),

	/** The Rented. */
	RENTED(2, "Rented", "Rented"),

	/** The Maintenance. */
	MAINTENANCE(3, "Maintenance", "Maintenance");

	/** The key. */
	private int key;

	/** The value. */
	private String value;

	/** The display value. */
	private String displayValue;

	/**
	 * Instantiates a new ticket CarStatus.
	 *
	 * @param key          the key
	 * @param value        the value
	 * @param displayValue the display value
	 */
	private CarStatus(int key, String value, String displayValue) {
		this.key = key;
		this.value = value;
		this.displayValue = displayValue;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the display value.
	 *
	 * @return the display value
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * Sets the display value.
	 *
	 * @param displayValue the new display value
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

}
