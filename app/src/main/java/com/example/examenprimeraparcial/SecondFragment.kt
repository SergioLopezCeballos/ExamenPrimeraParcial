package com.example.examenprimeraparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examenprimeraparcial.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private lateinit var questions: ArrayList<Question>
    private var indexQuestion: Int = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questions = ArrayList()
        var answers:ArrayList<Answer> = ArrayList()
        var question:Question

        answers.add(Answer(getString(R.string.answer_1_question_1_lbl_tag),true))
        answers.add(Answer(getString(R.string.answer_2_question_1_lbl_tag),false))
        answers.add(Answer(getString(R.string.answer_3_question_1_lbl_tag),false))
        question = Question(getString(R.string.question_1_lbl_tag),answers)
        questions.add(question)

        answers = ArrayList()
        answers.add(Answer(getString(R.string.answer_1_question_2_lbl_tag),true))
        answers.add(Answer(getString(R.string.answer_2_question_2_lbl_tag),false))
        answers.add(Answer(getString(R.string.answer_3_question_2_lbl_tag),false))
        question = Question(getString(R.string.question_2_lbl_tag),answers)
        questions.add(question)

        answers = ArrayList()
        answers.add(Answer(getString(R.string.answer_1_question_3_lbl_tag),false))
        answers.add(Answer(getString(R.string.answer_2_question_3_lbl_tag),true))
        answers.add(Answer(getString(R.string.answer_3_question_3_lbl_tag),false))
        question = Question(getString(R.string.question_3_lbl_tag),answers)
        questions.add(question)

        showQuestion(indexQuestion)

        binding.answer1.setOnClickListener {
            if (indexQuestion == 0) {
                print("Correcta")
            }

            if (indexQuestion == 1) {
                print("Correcta")
            }

            if (indexQuestion == 2) {
                print("Incorrecta")
            }
            indexQuestion++
            showQuestion(indexQuestion)
        }

        binding.answer2.setOnClickListener {
            if (indexQuestion == 0) {
                print("Incorrecta")
            }

            if (indexQuestion == 1) {
                print("Incorrecta")
            }

            if (indexQuestion == 2) {
                print("Correcta")
            }
            indexQuestion++
            showQuestion(indexQuestion)
        }

        binding.answer3.setOnClickListener {
            if (indexQuestion == 0) {
                print("Incorrecta")
            }

            if (indexQuestion == 1) {
                print("Incorrecta")
            }

            if (indexQuestion == 2) {
                print("Incorrecta")
            }
            indexQuestion++
            showQuestion(indexQuestion)
        }

    }

    fun showQuestion( index:Int) {
        if (indexQuestion < 3) {
            binding.countQuestionLbl.text = (indexQuestion + 1).toString() + "/3"
            binding.questionLbl.text = questions.get(indexQuestion).title
            binding.answer1.text = questions.get(indexQuestion).answers.get(0).title
            binding.answer2.text = questions.get(indexQuestion).answers.get(1).title
            binding.answer3.text = questions.get(indexQuestion).answers.get(2).title
        } else {
            print("ir a la ultima vista")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}