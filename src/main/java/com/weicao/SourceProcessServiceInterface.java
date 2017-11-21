package com.weicao;

public interface SourceProcessServiceInterface {

	LendersDAO readSource(String csvFile) throws InvalidSourceFileException;
}
