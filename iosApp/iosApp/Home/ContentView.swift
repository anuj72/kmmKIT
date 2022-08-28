import SwiftUI
import shared

struct ContentView: View {
    let greeting = AppRepo()
    @State var mError: String? = nil
    @State var array: [String] = []

  func load() {
        // print("hello")
        greeting.getDog(count: 3) { result, error in
            if let result = result {
                
           array=result.peekData() as! [String]
               
            } else if let error = error {
                mError = "Error: \(error)"
            }
        }
    }

var body: some View {
   List{
        VStack {
               ForEach(self.array, id: \.self) { value in
                RectangleImage(url: value)
                 Text("Doge")
               }
            }.onAppear {
                load()
            }
        
        ForEach(array, id: \.hash){value in
            Text(value)
            
        }
    }
   
    
}
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
