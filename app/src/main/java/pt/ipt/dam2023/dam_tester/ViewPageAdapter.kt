package pt.ipt.dam2023.dam_tester

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import pt.ipt.dam2023.dam_tester.fragmentos.Camara
import pt.ipt.dam2023.dam_tester.fragmentos.Creditos
import pt.ipt.dam2023.dam_tester.fragmentos.MenuPrincipal


class ViewPageAdapter(fragmentActivity:FragmentActivity): FragmentStateAdapter(fragmentActivity)  {

    override fun getItemCount(): Int{
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MenuPrincipal()
            1 -> Camara()
            2 -> BlankFragment()
            3 -> Creditos()
            else -> MenuPrincipal()
        }
    }
}