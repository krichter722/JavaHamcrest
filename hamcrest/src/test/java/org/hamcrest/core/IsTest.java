/**
 * BSD License
 *
 * Copyright (c) 2000-2021 www.hamcrest.org
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * Neither the name of Hamcrest nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.hamcrest.core;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.AbstractMatcherTest.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.IsEqual.equalTo;

public final class IsTest {

    @Test public void
    copesWithNullsAndUnknownTypes() {
        Matcher<String> matcher = is("something");
        
        assertNullSafe(matcher);
        assertUnknownTypeSafe(matcher);
    }

    @Test public void
    matchesTheSameWayTheUnderlyingMatcherDoes() {
        final Matcher<Boolean> matcher = is(equalTo(true));

        assertMatches(matcher, true);
        assertDoesNotMatch(matcher, false);
    }

    @Test public void
    generatesIsPrefixInDescription() {
        assertDescription("is <true>", is(equalTo(true)));
        assertDescription("is \"A\"", is("A"));
    }

    @Test public void
    providesConvenientShortcutForIsEqualTo() {
        final Matcher<String> matcher = is("A");
        
        assertMatches(matcher, "A");
        assertDoesNotMatch(is("A"), "B");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test public void
    providesConvenientShortcutForIsInstanceOf() {
        final Matcher matcher = isA(Number.class);
        assertMatches(matcher, 1);
        assertDoesNotMatch(matcher, new Object());
        assertDoesNotMatch(matcher, null);
    }
}
