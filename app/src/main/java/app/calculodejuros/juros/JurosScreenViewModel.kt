package app.calculodejuros.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.calculodejuros.calculos.calcularJuros
import app.calculodejuros.calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capitalState: LiveData<String> = _capital

    private val _taxa = MutableLiveData<String>()
    val taxaState: LiveData<String> = _taxa

    private val _tempo = MutableLiveData<String>()
    val tempoState: LiveData<String> = _tempo

    private val _juros = MutableLiveData<Double>() // observador
    val jurosState: LiveData<Double> = _juros // observavel

    private val _montante = MutableLiveData<Double>() // observador
    val montanteState: LiveData<Double> = _montante // observavel



    fun onCapitalChanged(novoCapital: String) {
        _capital.value = novoCapital
    }

    fun onTaxaChanged(novoTaxa: String) {
        _taxa.value = novoTaxa
    }

    fun onTempoChanged(novoTempo: String) {
        _tempo.value = novoTempo
    }

    fun calcularJurosViewModel(){
        _juros.value = calcularJuros(
            //essas variaveis podem ser nulas por isso uso o !! para poder ignorar esse fato
            capital = _capital.value!!.toDouble(),
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble()
        )
    }

    fun calcularMontanteViewModel(){
        _montante.value = calcularMontante(
            capital = _capital.value!!.toDouble(),
            juros = _juros.value!!.toDouble()
        )
    }
}