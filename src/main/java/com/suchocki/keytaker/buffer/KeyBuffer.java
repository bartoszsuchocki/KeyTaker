package com.suchocki.keytaker.buffer;

import java.util.List;

public interface KeyBuffer {

	public static final int DEFAULT_BUFFER_SIZE = 20;

	public void addKey(String keyText);

	public void removeLastKey();

	public List<String> getBuffer();

	public int getMaxSize();

	public void setMaxSize(int size);

	public int getElementsNumber();

	public String getPartOfBuffer(int start, int end);
}
