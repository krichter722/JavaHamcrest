/**
 * BSD License
 *
 * Copyright (c) 2000-2015 www.hamcrest.org
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
package org.hamcrest.text;

import static org.hamcrest.AbstractMatcherTest.*;
import org.hamcrest.Matcher;
import static org.hamcrest.text.IsBlankString.blankOrNullString;
import static org.hamcrest.text.IsBlankString.blankString;
import org.junit.Test;

/**
 * Is blank string test.
 */
public final class IsBlankStringTest {

    @Test
    public void copesWithNullsAndUnknownTypes() {
        Matcher<String> matcher = blankString();

        assertNullSafe(matcher);
        assertUnknownTypeSafe(matcher);
    }

    @Test
    public void matchesEmptyString() {
        assertMatches(blankOrNullString(), "");
        assertMatches(blankString(), "");
    }

    @Test
    public void matchesNullAppropriately() {
        assertMatches(blankOrNullString(), null);
        assertDoesNotMatch(blankString(), null);
    }

    @Test
    public void matchesBlankStringAppropriately() {
        assertMatches(blankString(), " \t");
        assertMatches(blankOrNullString(), " \t");
    }

    @Test
    public void doesNotMatchFilledString() {
        assertDoesNotMatch(blankString(), "a");
        assertDoesNotMatch(blankOrNullString(), "a");
    }

    @Test
    public void describesItself() {
        assertDescription("a blank string", blankString());
        assertDescription("(null or a blank string)", blankOrNullString());
    }

    @Test
    public void describesAMismatch() {
        assertMismatchDescription("was \"a\"", blankString(), "a");
        assertMismatchDescription("was \"a\"", blankOrNullString(), "a");
    }
}
