package com.kaaneneskpc.databinding

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class DataBindingExample : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataBindingExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val presenter = Presenter()
        binding.message = "Hello DataBinding"

    }
}

class Presenter {
    fun onSaveClick(view: View, context: Context) {
        // Save the user's data
    }
}



//DataBinding & ViewBinding

/*
   DataBinding :
    1)FindViewById kullanımı yapıldığında deep first searchde yukarıdan aşağıya bir arama yaptığı için(O(n)) performansı low cihazlarda baya düşüktür.
    2)FindviewByIdye farklı layouttaki bir idyi gelip farklı activityde verebilirz çalışır ancak ilgili sayfaya geldiğinde crash alırsın ve bu da zaman kaybına sebebiyet verir.
    (Compile time ya da build time safety yoktur.) - Null safety sağlamıyor.(Bir componente eriştiğinizde null olmayacağını garanti edemezsiniz)
     verilen component tipi farklı olabilir bunda da aynı şekilde build time safety yok.
    Kısa haliyle -> null safety değil, type safety değil, hiyerarşide 2 saat view araması, initializedan önce erişim sağlanabilir bu da hataya sebebiyet verir
    deep search ile yaptığı için performans sorununa sebebiyet veriyor.



    1)ViewBindingde implementation daha kolay.Databinding de layout ile sarmak durumunda kalıyorsunuz.
    2)DataBinding içerisinde çeştili veri tipi ya da event koyabilir ve direkt componente atama yapılabilir.
    3)Observe edilebilen bir yapıyı da ekleyebiliyoruz Databindingde(Daha sonradan component üzerinde yapılabilecek değişiklikler)(ViewBindingde yok)
    4)DataBindingde içinde binding adapterler yazılabilir.(xml üzerindeki business logiclerle mücadele etmek için. Test edilebilir olmuyor xml üzerindeki logicler)
    5)Two way binding(Edit textteki değişen textin alttaki text view'a yansıması gibi) DataBindingde var(View'ın kendi kendini update etme özelliği)


    Two way binding:
    Alınan veriyi direkt olarak component üzerine atama yapabiliriz. (ViewModel ya da fragment üzerinden editleme yapılabilirken
    bu işlemi component eventlar sayesinde tersine bir veriye güncelleme yapabiliriz.)

    <CheckBox
        android:id="@+id/checkBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checked="@={viewModel.rememberMe}" -> rememberMe değerini setledik sonrasında bu değer değişirse viewModeldeki rememberMe değerine setleme yapabiliyorum.
        android:text="CheckBox" />



    ViewBinding:
    Layout tagı yapmamıza gerek yok. (DataBindingde layout tagı yapmamız gerekiyor.)
    erişim databinding ile aynı ama hiçbir şekilde artık binding adapterları veya bind özelliğini kullanamıyoruz.(Abusive edilen yöntemler yaramadığı için)


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!  -> şeklinde kullanmamızın sebebi lifecycleaware
    olarak sadece create destroy arasında valid olsun diğer türlü this
    methodunu kullanmamız gerekir önceisnde erişmek istiyorsak. Ama best practice bu şekilde.


    onCreateView içerisinde _binding = ActivityMainBinding.inflate(layoutInflater) şeklinde kullanılır.
    val view = binding.root şeklinde kullanılır.

    onDestroyView içerisinde _binding = null şeklinde kullanılır.

    fragment lifecycle viewdan daha fazla yhaşadığı için onDestroyView'da bindingin referansını sildiğinizden emin olun.

    ViewBinding databindingdeki annotationlar gibi işlevsellik sağlamaz. (BindingAdapter, BindingMethods, BindingConversion, BindingAdapter, BindingMethods, BindingConversion)
    bu yüzdende generate edilen sıfnılardaki işlem gücü daha az ve hızlı derlenir.

    
*/