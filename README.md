# Lab Task 05 – Designing Specifications: Preconditions and Postconditions

**Course:** Software Construction — 5th Semester Software Engineering
**Instructor:** Engr. Rizwan Shah
**Date:** 15 Sep 2026

## Objective

Apply concepts of method specifications, behavioral equivalence, and fail-fast
precondition validation using JUnit testing.

## What Was Implemented

| File | Task | Description |
|---|---|---|
| `SearchStrategies.java` | Lab Task 1 | `findFirst` and `findLast` search an int array in opposite directions. They agree when a value appears exactly once, but disagree when duplicates exist or the value is missing (different "not found" return conventions), demonstrating behavioral equivalence depends on the specification and the client's use case. |
| `MathUtils.java` | Lab Task 2 | `calculateGravitationalPotentialEnergy(altitude)` documents its precondition (`altitude >= 0`) in JavaDoc and fails fast by throwing `IllegalArgumentException` immediately when violated, instead of returning a nonsensical result. |
| `ListFormatter.java` | Lab Task 3 | `sortInPlace` is explicitly specified to mutate its argument. `toLowerCase` is specified to leave its argument untouched and instead returns a brand-new list — demonstrating that mutation is only allowed when the spec says so. |
| `Authenticator.java` | Lab Task 4 | `getMitId` (insecure) returns a direct reference to an internal `char[]`, so a client's edits corrupt the object's internal cache. `getMitIdSecure` returns an immutable `String`, so no client operation can reach back and alter internal state — see the "Why immutability is a safer firewall" section below. |
| `JoinStrings.java` | Lab Task 5 | Contains both a bad, operational JavaDoc (describing the internal loop/StringBuilder/if-statement step by step) and a good, declarative JavaDoc (describing only the final observable output) for the same method, to contrast the two specification styles. |

Each task also has a corresponding JUnit 5 test class in `src/test/java/com/university/lab/lab5/`:
`SearchStrategiesTest`, `MathUtilsTest`, `ListFormatterTest`, `AuthenticatorTest`, `JoinStringsTest`.

## Why Immutability Is a Safer Firewall (Lab Task 4)

Returning a mutable object like `char[]` from `getMitId()` hands the caller a direct
reference to the class's internal state. Anything the caller does to that array —
even something as simple as overwriting a few characters — mutates the exact same
memory the `Authenticator` relies on internally, silently corrupting it with no
warning and no way for the class to prevent it.

Returning an immutable `String` from `getMitIdSecure()` closes that hole
completely. Java's `String` has no method that can change its own characters in
place — operations like `toUpperCase()` or `substring()` always return a **new**
`String` object rather than modifying the original. Because the internal
representation itself cannot be changed once created, handing out a `String`
reference is safe: the caller can read it, copy it, transform it into new strings,
but can never reach back and alter the original object's characters. This is why
immutable types act as a "firewall" — they let a class share data with the outside
world without ever risking that shared data being used as an accidental (or
intentional) backdoor into private internal state.

## How to Run

This is a Maven project.

### Option 1 — NetBeans

1. Open the project in NetBeans.
2. In the Projects panel, expand `Source Packages` → `com.university.lab.lab5`.
3. Right-click any class (e.g. `MathUtils.java`) → **Run File**.
4. To run tests: right-click a test class under `Test Packages` → **Test File**, or right-click the project → **Test**.

### Option 2 — Command line (Maven)

Compile:
```bash
mvn compile
```

Run a specific class:
```bash
mvn exec:java -Dexec.mainClass="com.university.lab.lab5.MathUtils"
```
Replace `MathUtils` with `SearchStrategies`, `ListFormatter`, `Authenticator`, or `JoinStrings` to run the others.

Run all JUnit tests:
```bash
mvn test
```

## Reflection

This lab made the idea of a "contract" between a method and its caller much more
concrete. Seeing `findFirst` and `findLast` disagree on arrays with duplicates
drove home that two methods can both be "correct" while still not being safely
interchangeable — it depends entirely on what the specification promises, not just
on what the code happens to do most of the time. Writing the fail-fast precondition
check in `MathUtils` was a good reminder that throwing early with a clear message
is far better than letting bad input silently propagate into a wrong answer.
Comparing `sortInPlace` and `toLowerCase` clarified that mutation should never be
assumed — it has to be explicitly part of the spec, or callers can be blindsided.
The `Authenticator` exercise was the most eye-opening: watching a client's
"harmless" edit to a returned `char[]` corrupt the object's own internal cache
made the risk of exposing mutable state feel real rather than theoretical, and
immediately justified why `String`'s immutability is a deliberate design choice,
not just a quirk. Writing both the bad operational JavaDoc and the good
declarative JavaDoc side by side for `joinStrings` was also useful — it was
tempting to describe *how* the loop works, but the declarative version is genuinely
easier for a caller to trust without reading the implementation. If I extended this
further, I'd add tests for edge cases like negative array indices in
`SearchStrategies` or extremely large lists in `JoinStrings` to see if the
specifications still hold up under stress.
