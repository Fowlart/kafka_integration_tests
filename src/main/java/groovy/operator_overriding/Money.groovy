package groovy.operator_overriding

import groovy.transform.Immutable

/***
 *
 * class Money - It’s an implementation of the Value Object9 pattern  http://c2.com/cgi/wiki?ValueObject
 *
 ***/

@Immutable
// Because every immutable object automatically gets a value-based implementation of equals,
// you get away with only a minimal declaration for override equals
class Money {

    int amount
    String currency

    // In this case, operator implementing is the best wording.
    Money plus(Money other) {

        if (null == other) return this

        if (other.currency != currency) {
            throw new IllegalArgumentException("cannot add $other.currency to $currency")
        }

        return new Money(amount + other.amount, currency)
    }

    Money plus(Integer more) {
        return new Money(amount + more, currency)
    }

    static void main(String[] args) {
        Money buck = new Money(1, 'USD') // @Immutable - is generated equals
        assert buck + buck == new Money(2, 'USD') // used Money plus(Money other)
        assert buck + 1 == new Money(2, 'USD')// used Money plus(Integer more)
    }
}