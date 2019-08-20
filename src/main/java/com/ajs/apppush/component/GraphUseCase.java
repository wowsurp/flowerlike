package com.ajs.apppush.component;

import graphql.ExecutionResult;

public interface GraphUseCase {
	ExecutionResult execute(String query);
}
