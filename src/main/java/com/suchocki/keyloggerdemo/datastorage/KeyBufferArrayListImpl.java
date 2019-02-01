package com.suchocki.keyloggerdemo.datastorage;

import java.util.ArrayList;
import java.util.List;

public class KeyBufferArrayListImpl implements Keybuffer {
	private int maxSize;
	private List<String> buffer;

	public KeyBufferArrayListImpl(int size) {
		this.maxSize = size;
		buffer = new ArrayList<>();
	}

	public void addKey(String keyText) {
		if (buffer.size() == maxSize) {
			buffer.remove(0);
		}
		buffer.add(keyText);
	}

	@Override
	public void removeLastKey() {
		buffer.remove(buffer.size() - 1);
	}

	@Override
	public List<String> getBuffer() {
		return buffer;
	}

	@Override
	public String getPartOfBuffer(int start, int end) {
		if (start < 0 || end > buffer.size()) {
			throw new IndexOutOfBoundsException();
		}
		StringBuilder result = new StringBuilder();
		for (int i = start; i < end; i++) {
			result.append(buffer.get(i));
		}
		return result.toString();
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public int getElementsNumber() {
		return buffer.size();
	}

}