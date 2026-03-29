package org.example.kick_task1.specification;

import org.example.kick_task1.entity.IntArray;

public interface Specification {

    boolean isSatisfiedBy(IntArray item);

    default Specification or(Specification spec) {
        return item->this.isSatisfiedBy(item)||spec.isSatisfiedBy(item);
    }

    default Specification and(Specification spec) {
        return item->this.isSatisfiedBy(item)&&spec.isSatisfiedBy(item);
    }

    default Specification not() {
        return item->!this.isSatisfiedBy(item);
    }
}
