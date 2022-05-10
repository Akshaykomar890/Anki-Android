package com.ichi2.anki.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.ichi2.anki.lint.rules.ConstantJavaFieldDetector
import com.ichi2.anki.lint.rules.CopyrightHeaderExists
import com.ichi2.anki.lint.rules.DirectCalendarInstanceUsage
import com.ichi2.anki.lint.rules.DirectDateInstantiation
import com.ichi2.anki.lint.rules.DirectGregorianInstantiation
import com.ichi2.anki.lint.rules.DirectSnackbarMakeUsage
import com.ichi2.anki.lint.rules.DirectSystemCurrentTimeMillisUsage
import com.ichi2.anki.lint.rules.DirectSystemTimeInstantiation
import com.ichi2.anki.lint.rules.DirectToastMakeTextUsage
import com.ichi2.anki.lint.rules.DuplicateCrowdInStrings
import com.ichi2.anki.lint.rules.DuplicateTextInPreferencesXml
import com.ichi2.anki.lint.rules.FixedPreferencesTitleLength
import com.ichi2.anki.lint.rules.InconsistentAnnotationUsage
import com.ichi2.anki.lint.rules.InvalidStringFormatDetector
import com.ichi2.anki.lint.rules.JUnitNullAssertionDetector
import com.ichi2.anki.lint.rules.KotlinMigrationBrokenEmails
import com.ichi2.anki.lint.rules.KotlinMigrationFixLineBreaks
import com.ichi2.anki.lint.rules.NonPositionalFormatSubstitutions
import com.ichi2.anki.lint.rules.NonPublicNonStaticJavaFieldDetector
import com.ichi2.anki.lint.rules.PreferIsEmptyOverSizeCheck
import com.ichi2.anki.lint.rules.PrintStackTraceUsage
import com.ichi2.anki.lint.rules.VariableNamingDetector
import com.ichi2.anki.lint.utils.KotlinCleanup
import java.util.ArrayList

@KotlinCleanup("listOf")
class IssueRegistry : IssueRegistry() {
    // Keep this list lexicographically ordered.
    override val issues: List<Issue>
        get() {
            // Keep this list lexicographically ordered.
            val issues: MutableList<Issue> = ArrayList()
            issues.add(CopyrightHeaderExists.ISSUE)
            issues.add(DirectCalendarInstanceUsage.ISSUE)
            issues.add(DirectDateInstantiation.ISSUE)
            issues.add(DirectGregorianInstantiation.ISSUE)
            issues.add(DirectSnackbarMakeUsage.ISSUE)
            issues.add(DirectSystemCurrentTimeMillisUsage.ISSUE)
            issues.add(DirectSystemTimeInstantiation.ISSUE)
            issues.add(DirectToastMakeTextUsage.ISSUE)
            issues.add(DuplicateCrowdInStrings.ISSUE)
            issues.add(DuplicateTextInPreferencesXml.ISSUE)
            issues.add(InconsistentAnnotationUsage.ISSUE)
            issues.add(JUnitNullAssertionDetector.ISSUE)
            issues.add(KotlinMigrationBrokenEmails.ISSUE)
            issues.add(KotlinMigrationFixLineBreaks.ISSUE)
            issues.add(PreferIsEmptyOverSizeCheck.ISSUE)
            issues.add(PrintStackTraceUsage.ISSUE)
            issues.add(NonPositionalFormatSubstitutions.ISSUE)
            issues.add(NonPublicNonStaticJavaFieldDetector.ISSUE)
            issues.add(ConstantJavaFieldDetector.ISSUE)
            issues.add(FixedPreferencesTitleLength.ISSUE_MAX_LENGTH)
            issues.add(FixedPreferencesTitleLength.ISSUE_TITLE_LENGTH)
            issues.add(VariableNamingDetector.ISSUE)
            issues.add(InvalidStringFormatDetector.ISSUE)
            return issues
        }
    override val api: Int
        get() = CURRENT_API
    override val vendor: Vendor?
        get() = Vendor(
            "AnkiDroid",
            "com.ichi2.anki:lint-rules",
            "https://github.com/ankidroid/Anki-Android/issues",
            "https://github.com/ankidroid/Anki-Android"
        )
}