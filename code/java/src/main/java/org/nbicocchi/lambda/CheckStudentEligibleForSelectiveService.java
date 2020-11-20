package org.nbicocchi.lambda;

import org.nbicocchi.utils.Student;

class CheckPersonEligibleForSelectiveService implements CheckStudent {
    public boolean test(Student p) {
        return p.getAverage() >= 20 && p.getAverage() <= 24;
    }
}
