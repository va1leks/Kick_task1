package org.example.kick_task1.specification;

import org.example.kick_task1.entity.MyArray;

public interface Specification {

    boolean isSatisfiedBy(MyArray item);

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
