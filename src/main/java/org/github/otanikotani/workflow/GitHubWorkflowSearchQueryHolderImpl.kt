package org.github.otanikotani.workflow

import com.intellij.openapi.Disposable
import org.jetbrains.plugins.github.ui.util.SingleValueModel

internal class GitHubWorkflowSearchQueryHolderImpl : GitHubWorkflowSearchQueryHolder {
    private val delegate = SingleValueModel(GitHubWorkflowSearchQuery.parseFromString("state:open"))

    override var query: GitHubWorkflowSearchQuery
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    override fun addQueryChangeListener(disposable: Disposable, listener: () -> Unit) =
        delegate.addValueChangedListener(disposable, listener)
}