package graphql.execution.nextgen.result;

import graphql.Internal;
import graphql.execution.MergedField;
import graphql.execution.NonNullableFieldWasNullException;
import graphql.execution.nextgen.FetchedValueAnalysis;

import java.util.List;
import java.util.Map;

@Internal
public abstract class ExecutionResultNode {

    private final FetchedValueAnalysis fetchedValueAnalysis;
    private final NonNullableFieldWasNullException nonNullableFieldWasNullException;

    protected ExecutionResultNode(FetchedValueAnalysis fetchedValueAnalysis, NonNullableFieldWasNullException nonNullableFieldWasNullException) {
        this.fetchedValueAnalysis = fetchedValueAnalysis;
        this.nonNullableFieldWasNullException = nonNullableFieldWasNullException;
    }

    public FetchedValueAnalysis getFetchedValueAnalysis() {
        return fetchedValueAnalysis;
    }

    public MergedField getMergedField() {
        return fetchedValueAnalysis.getExecutionStepInfo().getField();
    }

    public NonNullableFieldWasNullException getNonNullableFieldWasNullException() {
        return nonNullableFieldWasNullException;
    }

    public abstract List<ExecutionResultNode> getChildren();

    public abstract ExecutionResultNode withChild(ExecutionResultNode child, ExecutionResultNodePosition position);

    public abstract ExecutionResultNode withNewChildren(Map<ExecutionResultNodePosition, ExecutionResultNode> children);


}
