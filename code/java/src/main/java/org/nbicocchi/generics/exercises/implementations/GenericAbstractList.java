package org.nbicocchi.generics.exercises.implementations;

/**
 * Simplified implementation of a generic Abstract List. Contains code shared
 * among all classes implementing GenericList methods
 *
 * @author Nicola Bicocchi
 */
public abstract class GenericAbstractList<T> implements GenericList<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", get(i).toString()));
        }
        return sb.toString();
    }

}
