package com.example.lint.checks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod


class SampleIssueDetector : Detector(), SourceCodeScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {
            override fun visitMethod(node: UMethod) {

                val hasAnnotation =  node.hasAnnotation(JVM_STATIC_ANNOTATION)
                val findAnnotation =  node.findAnnotation(JVM_STATIC_ANNOTATION)

                if (hasAnnotation && findAnnotation == null) {
                    throw IllegalStateException("hasAnnotation returns true but findAnnotation returns false")
                }
            }
        }
    }

    companion object {
        private const val JVM_STATIC_ANNOTATION = "kotlin.jvm.JvmStatic"

        /**
         * Issue describing the problem and pointing to the detector
         * implementation.
         */
        @JvmField
        val ISSUE: Issue = Issue.create(
            // ID: used in @SuppressLint warnings etc
            id = "SampleId2",
            // Title -- shown in the IDE's preference dialog, as category headers in the
            // Analysis results window, etc
            briefDescription = "Lint Mentions2",
            // Full explanation of the issue; you can use some markdown markup such as
            // `monospace`, *italic*, and **bold**.
            explanation = """
                    AAAAAAAA
                    """, // no need to .trimIndent(), lint does that automatically
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.FATAL,
            implementation = Implementation(
                SampleIssueDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

}
