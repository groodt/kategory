package kategory

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.properties.forAll
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class OptionMonoidTest : UnitSpec() {
    init {
        "should semigroup with the instance passed" {
            forAll { _: Int ->
                val optionMonoid = Option.monoid(NonEmptyList.semigroup<Int>())
                val seen = optionMonoid.combine(Option.None, Option.None)
                val expected = Option.None

                expected == seen
            }
        }

        "should semigroup with the instance passed" {
            forAll { value: Int ->
                val optionMonoid = Option.monoid(NonEmptyList.semigroup<Int>())
                val seen = optionMonoid.combine(Option.Some(kategory.NonEmptyList.of(value)), Option.None)
                val expected = Option.None

                expected == seen
            }
        }

        "should semigroup with the instance passed" {
            forAll { value: Int ->
                val optionMonoid = Option.monoid(NonEmptyList.semigroup<Int>())
                val seen = optionMonoid.combine(Option.None, Option.Some(NonEmptyList.of(value)))
                val expected = Option.None

                expected == seen
            }
        }

        "should semigroup with the instance passed" {
            forAll { value: Int ->
                val optionMonoid = Option.monoid(NonEmptyList.semigroup<Int>())
                val seen = optionMonoid.combine(Option.Some(NonEmptyList.of(value)), Option.Some(NonEmptyList.of(value)))
                val expected = Option.Some(NonEmptyList.of(value, value))

                expected == seen
            }
        }
    }
}
