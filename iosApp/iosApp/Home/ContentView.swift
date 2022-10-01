import SwiftUI
import shared

struct ContentView: View {
    let greeting = AppRepo()
    @State var mError: String? = nil
    @State var array: [String] = []
    @ObservedObject var vm = MainVM()

 

var body: some View {
   List{
        VStack {
            ForEach(vm.array, id: \.self) { value in
                RectangleImage(url: value)
                 Text("Doge")
               }
            }.onAppear {
                vm.load()
            }
        
//        ForEach(array, id: \.hash){value in
//            Text(value)
//
//        }
    }
   
    
}
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
