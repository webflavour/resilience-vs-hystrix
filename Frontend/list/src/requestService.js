import React from "react";
import ListHeaders from './components/ListHeader';
import NewItem from "./components/AddItem";
import Item from "./components/Item";
import Filter from "./components/Filter";
import useFetch from "./Hooks/use-fetch";

// Hier kommt serverUrl der API, wenn Hystrix oder Resilience als Backend laufen, sonst ist Mock API angebunden für Testzwecke



const List = () => {
    const [list, setList] = React.useState([]);
    const [newItem, setNewItem] = React.useState("");
    const [loading, setLoading] = React.useState(false);
    const [filter, setFilter] = React.useState("all");
    const itemApi = useFetch(
        "https://5cfabdcbf26e8c00146d0b0e.mockapi.io/tasks"
  /*  const itemApi = useFetch(
        "http://localhost:8080/"*/
    );

    React.useEffect(() => {
        setLoading(true);
        itemApi
            .get()
            .then(data => data.sort((a, b) => (a.createdAt < b.createdAt ? 1 : -1)))
            .then(data => setList(data));
        setLoading(false);
    }, []);

    const addItem = () => {
        if (!newItem) return;
        setLoading(true);
        itemApi
            .post({
                description: newItem,
                createdAt: new Date().toISOString(),
                done: false,
                updatedAt: ""
            })
            .then(data => {
                const newList = [...list, data].sort((a, b) =>
                    a.createdAt < b.createdAt ? 1 : -1
                );
                setList(newList);
                setNewItem("");
                setLoading(false);
            });
    };

    const completeItem = item => {
        const { id, done } = item;

        setLoading(true);
        itemApi
            .put(id, {
                done: !done,
                updatedAt: new Date().toISOString()
            })
            .then(data => {
                const newList = list
                    .map(l => {
                        if (l.id === id) {
                            l.done = data.done;
                            l.updatedAt = data.updatedAt;
                        }
                        return l;
                    })
                    .sort((a, b) => (a.createdAt < b.createdAt ? 1 : -1));
                setList(newList);
                setNewItem("");
                setLoading(false);
            });
    };

    const removeItem = item => {
        const { id } = item;
        setLoading(true);
        itemApi.del(id).then(data => {
            const newList = list
                .filter(l => l.id !== data.id)
                .sort((a, b) => (a.createdAt < b.createdAt ? 1 : -1));
            setList(newList);
            setLoading(false);
        });
    };

    const filteredList = list.filter(
        item =>
            filter === "all" ||
            (filter === "done" && item.done) ||
            (filter === "pending" && !item.done)
    );

    return (
        <div className="row">
            {loading ? <div className="loading" /> : ""}
            <div className="col-8">
                <NewItem addItem={addItem} newItem={newItem} setNewItem={setNewItem} />
            </div>
            <div className="col">
                <Filter filter={filter} setFilter={setFilter} />
            </div>
            <div className="col-12">
                <hr />
            </div>

            <div className="col-12">
                <ul className="list-group">
                    <ListHeaders />
                    {filteredList.map(item => (
                        <Item
                            item={item}
                            completeItem={completeItem}
                            removeItem={removeItem}
                            id={item.id}
                        />
                    ))}
                </ul>
            </div>
        </div>
    );
};
export default List;
