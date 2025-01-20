package com.nikhilproject.presentation.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nikhilproject.presentation.databinding.BottomSheetDialogBinding

class BottomSheetDialogFragment(
    private val totalCharacterCount: Int,
    private val topCharacters: List<Pair<Char, Int>>
) : BottomSheetDialogFragment() {

    private lateinit var bottomSheetBinding: BottomSheetDialogBinding

    companion object {
        const val TAG = "ModalBottomSheetDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bottomSheetBinding = BottomSheetDialogBinding.inflate(
            inflater,
            container,
            false
        )
        setBottomSheetData()
        return bottomSheetBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val bottomSheet =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let { view ->
                val behavior = BottomSheetBehavior.from(view)
                behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    private fun setBottomSheetData() {
        bottomSheetBinding.tvItemCount.text =
            "Total character count: $totalCharacterCount"

        bottomSheetBinding.tvFirstTopCharacter.text =
            "1. ${topCharacters[0].first}: ${topCharacters[0].second}"
        bottomSheetBinding.tvSecondTopCharacter.text =
            "2. ${topCharacters[1].first}: ${topCharacters[1].second}"
        bottomSheetBinding.tvThirdTopCharacter.text =
            "3. ${topCharacters[2].first}: ${topCharacters[2].second}"
    }

}