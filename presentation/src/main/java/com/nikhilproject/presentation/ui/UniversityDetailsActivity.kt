package com.nikhilproject.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nikhilproject.domain.model.Course
import com.nikhilproject.domain.model.University
import com.nikhilproject.presentation.databinding.ActivityUniversityDetailsBinding
import com.nikhilproject.presentation.utils.UIState
import com.nikhilproject.presentation.viewmodel.UniversityDetailsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class UniversityDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityDetailsBinding
    private val viewModel: UniversityDetailsViewModel by lazy {
        getViewModel()
    }

    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var coursesAdapter: CoursesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUniversityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val splashscreen = installSplashScreen()
        var keepSplashScreen = true

        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(3000)
            keepSplashScreen = false
        }

        init()
        setUpObserver()

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterCourses(newText ?: "")
                return true
            }
        })

        binding.fab.setOnClickListener {
            val courses = viewModel.selectedCourses.value
            val totalCharacterCount = getTotalCharacterCount(courses)
            val topCharacters = getTopThreeCharacters(courses)
            showBottomSheetDialog(totalCharacterCount, topCharacters)
        }
    }

    private fun getTotalCharacterCount(courses: List<Course>): Int {
        var totalCount = 0
        courses.forEach { course ->
            totalCount += (course.name.length + course.professor.length)
        }

        return totalCount
    }

    private fun getTopThreeCharacters(courses: List<Course>): List<Pair<Char, Int>> {
        val charFrequency = mutableMapOf<Char, Int>()

        // Extract characters from both course name and professor, and count frequencies
        courses.forEach { course ->
            (course.name + course.professor)
                .filter { it.isLetter() }
                .forEach { char ->
                    charFrequency[char] = charFrequency.getOrDefault(char, 0) + 1
                }
        }

        // Sort by frequency in descending order and take the top 3
        return charFrequency.entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key to it.value }
    }

    private fun showBottomSheetDialog(totalCharacterCount: Int, topCharacters: List<Pair<Char, Int>>) {

        val modal = BottomSheetDialogFragment(totalCharacterCount, topCharacters)
        supportFragmentManager.let {
            modal.show(it, BottomSheetDialogFragment.TAG)
        }
    }

    private fun setUpObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collectLatest { state ->
                        when (state) {
                            is UIState.Success -> {
                                binding.progressBar.visibility = View.GONE
                                setUpCarousel(state.data)
                                viewModel.setSelectedUniversity(0)
                            }

                            is UIState.Loading -> binding.progressBar.visibility = View.VISIBLE
                            is UIState.Error -> binding.progressBar.visibility = View.GONE
                        }
                    }
                }

                launch {
                    viewModel.selectedCourses.collectLatest { courses ->
                        setCourseAdapter(courses)
                    }
                }
            }
        }
    }

    private fun init() {
        binding.homeCarousel.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.setSelectedUniversity(position)
                resetSearchQuery()
            }
        })
    }

    private fun setUpCarousel(carouselData: List<University>) {
        carouselAdapter = CarouselAdapter(this, carouselData)
        binding.homeCarousel.viewPager.adapter = carouselAdapter

        TabLayoutMediator(
            binding.homeCarousel.tabLayout,
            binding.homeCarousel.viewPager
        ) { _, _ -> }.attach()
    }

    private fun setCourseAdapter(courseData: List<Course>) {
        if (!::coursesAdapter.isInitialized) {
            coursesAdapter = CoursesAdapter(courseData)
            binding.itemList.apply {
                adapter = coursesAdapter
                layoutManager = LinearLayoutManager(this@UniversityDetailsActivity)
            }
        } else {
            coursesAdapter.updateData(courseData)
        }
    }

    private fun resetSearchQuery() {
        binding.search.setQuery("", false)
        binding.search.clearFocus()
    }
}
